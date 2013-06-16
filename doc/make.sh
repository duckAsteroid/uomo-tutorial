#!/bin/bash
mkdir target
mkdir target/images
cp images/* target/images
asciidoc -b html5 -a source-highlighter=pygments -a toc2 --theme=flask -o target/tutorial.html tutorial.asciidoc
a2x -a source-highlighter=pygments -f pdf -D ./target tutorial.asciidoc
a2x -a source-highlighter=pygments -f epub -D ./target tutorial.asciidoc
