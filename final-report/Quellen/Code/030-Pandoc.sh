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
--pdf-engine=pdflatex \
-V page-background=background.pdf \
-V titlepage=true \
-V titlepage-background=title.pdf \
-V titlepage-rule-height=0 \
-V code-block-font-size="\footnotesize" \
-V lang=de

# Pandoc <  v2: markdown_github+raw_tex
# Pandoc 2.12: "[WARNING] Deprecated: markdown_github. Use gfm instead."
# Pandoc 2.12: Table errors
# Pandoc 2.12: gfm -> no newline, no table width?

# --verbose \

popd > /dev/null
