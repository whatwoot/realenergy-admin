@echo off
echo.
echo [ÐÅÏ¢] ÇåÀí¹¤³ÌtargetÉú³ÉÂ·¾¶¡£
echo.

%~d0
cd %~dp0

cd ..
call mvn clean

pause