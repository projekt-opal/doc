#!/bin/bash

if [ $# -eq 0 ]
  then
    echo "Error: Please specify a data directory"
fi

DIR=$1
if [ ! -d "$DIR" ]; then
    echo "Error: Directory $DIR does not exist."
fi

cp eisvogel.tex $DIR
cp OPAL_D8-5_Background.pdf $DIR
cp OPAL_D8-5_Title.pdf $DIR

pushd $DIR > /dev/null

pandoc OPAL-Dokumentation.md \
--from markdown_github+raw_tex \
-o OPAL_D8.5_Documentation.pdf \
--template ./eisvogel.tex \
--listings \
--toc \
-V page-background=OPAL_D8-5_Background.pdf \
-V titlepage=true \
-V titlepage-background=OPAL_D8-5_Title.pdf \
-V titlepage-rule-height=0 \
-V code-block-font-size="\footnotesize"

popd > /dev/null
