#!/bin/bash

ant generated-soyutils SoyToJsSrcCompiler &&
cp build/SoyToJsSrcCompiler.jar package &&
cp build/javascript/* package
