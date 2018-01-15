@echo off
@REM SET GREEN=[32m
@REM SET CYAN=[36m
@REM SET NC=[0m
SET CURRENT_DIR=%CD%

echo ----

@REM Set user email
set /p email="Set your email adress: "
git config --local user.email "%email%"
echo User email was set to '%email%'

@REM Set user name
set /p name="Set your user name: "
git config --local user.name "%name%"
echo User name was set to '%name%'.'

@REM Set gitflow path
SET GITFLOW_PATH_HOOKS=%CURRENT_DIR%\.git\hooks
git config --local gitflow.path.hooks "%GITFLOW_PATH_HOOKS%"
echo GitFlow hooks path was successfully set to '%GITFLOW_PATH_HOOKS%'

@REM Connect .gitconfig
SET GITCONFIG_PATH=%CURRENT_DIR%\.gitconfig
git config --local include.path "%GITCONFIG_PATH%"
echo .gitconfig path was successfully set to '%GITCONFIG_PATH%'
echo ----