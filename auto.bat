@echo off
setlocal enabledelayedexpansion

:: List of files
set files=CRC1.java Ford.java RSA.java LeakyBucket.java BellmanFord.java TCP.java UDP.java

echo Available files:
for %%f in (%files%) do echo %%f

set /p choice=Enter the filename you want to download: 

:: Build raw URL
set url=https://raw.githubusercontent.com/Hkaren90/javaprog/main/%choice%

:: Download using curl (built into Windows 10/11)
curl -sL %url% -o %choice%

echo Downloaded %choice% successfully!
pause
