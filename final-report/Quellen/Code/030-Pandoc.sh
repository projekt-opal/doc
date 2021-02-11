#!/bin/bash

# https://github.com/Wandmalfarbe/pandoc-latex-template

pushd ../../Tmp > /dev/null

pandoc content.md \
--from markdown_github+raw_tex \
-o OPAL-Open-Data-Portal-Germany-Projektergebnisse.pdf \
--template eisvogel.tex \
--number-sections \
--listings \
--toc \
-V page-background=background.pdf \
-V titlepage=true \
-V titlepage-background=title.pdf \
-V titlepage-rule-height=0 \
-V code-block-font-size="\footnotesize" \
-V lang=de

popd > /dev/null
