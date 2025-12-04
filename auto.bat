@echo off
setlocal enabledelayedexpansion

:: List of files
set files=PR10.java Checksum.java ShortestPath.java Encryptor.java LeakyBucket.java BellmanFord.java TCP.java UDP.java

echo Available files:
for %%f in (%files%) do echo %%f

set /p choice=Enter the filename you want to view: 

:: Build raw URL
set url=https://raw.githubusercontent.com/Hkaren90/javaprog/main/%choice%

:: Display file contents directly
curl -sL %url%

pause
