#!/bin/bash

echo -e "Script per automatizzare la compilazione delle classi Java JPA (funziona solo su Linux)\n"
echo -e "Affinché la compilazione abbia successo, copiare questo script nella cartella src del progetto le cui classi volete compilare."
echo -e "Se la linea di comando vi dice 'impossibile eseguire il comando: permesso negato' o una frase simile, rendete eseguibile lo script con il seguente comando: chmod u+x build.sh\n"

if [[ -z ${1} || -z ${2} ]]
then
  echo -e "./build.sh percorso-del-vostro-connector-j/mysql-connector-java-5.0.8-bin.jar *java\n";
  exit 1; 
fi

connector="${1}"
app="${2}"
del=".java"
sub=""

app="${app/$del/$sub}"

echo -e "Eseguo javac"

$(javac -g -cp ${connector} *.java)
echo -e "Compilazione avvenuta con successo"

$(cp *.class ../bin && rm *.class)

$(cd ../bin && $(java -cp .:${connector} ${app}))


