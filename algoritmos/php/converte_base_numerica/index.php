<?php 
    function principal()
    {
        $numerosNaBaseDecimal = array();
        $numerosNaBaseDecimal = preencherVetordecimal($numerosNaBaseDecimal);

        $numerosNaBaseBinario = array();
        $numerosNaBaseBinario = converterArrayDecimalParaBinario($numerosNaBaseDecimal);

        $numerosNaBaseOctal = array();
        $numerosNaBaseOctal = converterArrayDecimalParaOctal($numerosNaBaseDecimal);

        $numerosNaBaseHexadecimal = array();
        $numerosNaBaseHexadecimal = converterArrayDecimalParaHexadecimal($numerosNaBaseDecimal);

        exibirDadosDosVetores($numerosNaBaseDecimal,$numerosNaBaseBinario,$numerosNaBaseOctal,$numerosNaBaseHexadecimal);
    }

    function preencherVetordecimal($vetorDecimal = array())
    {
        for($i = 0; $i <= 255; $i = $i+1)
        {
            $vetorDecimal[$i] = $i;
        }

        return $vetorDecimal;
    }
    
    function converterArrayDecimalParaBinario($vetorDecimal = array())
    {
        $vetorBinario = array();
        foreach($vetorDecimal as $numeroDecimal)
        {
            $vetorBinario[$numeroDecimal] = converterNumeroNaBaseDesejada($numeroDecimal,2);
        }

        return $vetorBinario;
    }

    function converterArrayDecimalParaOctal($vetorDecimal = array())
    {
        $vetorOctal = array();
        foreach($vetorDecimal as $numeroDecimal)
        {
            $vetorOctal[$numeroDecimal] = converterNumeroNaBaseDesejada($numeroDecimal,8);
        }

        return $vetorOctal;
    }

    function converterArrayDecimalParaHexadecimal($vetorDecimal = array())
    {
        $vetorHexadecimal = array();
        foreach($vetorDecimal as $numeroDecimal)
        {
            $vetorHexadecimal[$numeroDecimal] = converterNumeroNaBaseDesejada($numeroDecimal,16);
        }

        return $vetorHexadecimal;
    }
    
    function converterNumeroNaBaseDesejada($decimal,$baseNumerica)
    {
        $numeroNaBaseDesejada = array();

        if($decimal < $baseNumerica)
        {
            if($baseNumerica == 16)
            {
                return converterParaAlgarismoHexadecimal($decimal);
            }
            else
            {
                return $decimal;
            }
        }
        else
        {
            while($decimal >= $baseNumerica)
            {
                if($baseNumerica == 16)
                {
                    $numeroNaBaseDesejada[] = converterParaAlgarismoHexadecimal($decimal % $baseNumerica);
                    $decimal = intval($decimal / $baseNumerica);
                }
                else
                {
                    $numeroNaBaseDesejada[] = ($decimal % $baseNumerica);
                    $decimal = intval($decimal / $baseNumerica);
                }

            }
            if($baseNumerica == 16)
            {
                $numeroNaBaseDesejada[] = converterParaAlgarismoHexadecimal($decimal);
            }
            else
            {
                $numeroNaBaseDesejada[] = $decimal;
            }
        }
        return  (inverterValorQualquer($numeroNaBaseDesejada));
    }

    function inverterValorQualquer($valorQualquer = array())
    {
        $valorInvertido = "";
        for($i = count($valorQualquer) - 1; $i >= 0; $i = $i-1)
        {
            $valorInvertido = $valorInvertido . $valorQualquer[$i];
        }
        return  $valorInvertido;
    }

    function converterParaAlgarismoHexadecimal($numeroHexadecimal)
    {
        switch ($numeroHexadecimal)
        {
            case (10):
                return "A";
            case (11):
                return "B";
            case (12):
                return "C";
            case (13):
                return "D";
            case (14):
                return "E";
            case (15):
                return "F";
            default:
                return $numeroHexadecimal;
        }
    }

    function exibirDadosDosVetores($vetorDecimal = array(),$vetorBinario = array(),$vetorOctal = array(),$vetorHexadecimal = array())
    {
        for($i = 0; $i <= 255;$i = $i +1)
        {   echo "<tr>";
                for($j = 1; $j <= 4; $j = $j + 1)
                {
                echo "<td>";
                    if($j == 1)
                    {
                        echo ("D:". $vetorDecimal[$i]);
                    }   
                    else
                    {
                        if($j == 2)
                        {
                            echo ("B:". $vetorBinario[$i]);
                        }
                        else
                        {
                            if($j == 3)
                            {
                                echo ("O:". $vetorOctal[$i]);  
                            }
                            else
                            {
                                echo ("H:". $vetorHexadecimal[$i]);
                            }
                        }
                    }
                echo "</td>";
                }
            echo "</tr>";
        }
    }
?>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Converter base numerica</title>
    <link rel="stylesheet" href="estilo.css">
</head>
<body>
    <h1>Abaixo há uma tabela contendo os resultados da conversão</h1>
    <table>
        <thead>
            <tr>
                <th><h2>|Decimal|</h2></th>
                <th><h2 id="binario">Binario|</h2></th>
                <th><h2>Octal|</h2></th>
                <th><h2>Hexadecimal|</h2></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><?php principal(); ?></td>
            </tr>
        </tbody>
    </table>
</body>
</html>