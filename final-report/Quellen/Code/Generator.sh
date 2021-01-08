#!/bin/sh

echo ''
echo '# Inhalte zusammenfuehren'
./010-Markdown.sh

echo ''
echo '# Dateien kopieren'
./020-Kopieren.sh

echo ''
echo '# Pandoc'
./030-Pandoc.sh

echo ''

