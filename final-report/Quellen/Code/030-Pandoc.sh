#!/bin/bash

pushd ../../Tmp > /dev/null

pandoc content.md \
--from markdown_github+raw_tex \
-o OPAL_Abschlussbericht.pdf \
--template eisvogel.tex \
--listings \
--toc \
-V page-background=background.pdf \
-V titlepage=true \
-V titlepage-background=title.pdf \
-V titlepage-rule-height=0 \
-V code-block-font-size="\footnotesize"

popd > /dev/null
