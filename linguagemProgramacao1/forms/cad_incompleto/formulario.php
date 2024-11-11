<?php
    $nome = isset($_GET['nome']) ? $_GET['nome'] : "";
    $termo = isset($_GET['termo']) ? "checado" : "não";

    print "Nome".$nome." com termo ".$termo;
    //print "Nome {$nome} com termo {$termo}";
    