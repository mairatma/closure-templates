#!/bin/bash

ant generated-soyutils SoyToJsSrcCompiler &&
ant generated-soyutils SoyMsgExtractor &&
cp build/SoyToJsSrcCompiler.jar package &&
cp build/SoyMsgExtractor.jar package &&
cp build/javascript/* package
