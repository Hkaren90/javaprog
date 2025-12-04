@echo off
setlocal enabledelayedexpansion

:: List of files
set files=PR4.java PR6.java PR7A.java PR7B.java PR8A.java PR8B.java PR9.java PR10.java

echo Available files:
for %%f in (%files%) do echo %%f

set /p choice=Enter the filename you want to view: 

:: Build raw URL
set url=https://raw.githubusercontent.com/Hkaren90/javaprog/main/%choice%

:: Display file contents directly
curl -sL %url%

pause
