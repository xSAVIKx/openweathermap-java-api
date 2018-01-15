#!/usr/bin/env bash

# Set colors
GREEN='\033[1;32m'
CYAN='\033[1;36m'
NC='\033[0m'
CURRENT_DIR=$(pwd)

printf "${GREEN}----${NC}"

echo

# Set user email
read -p "Set your email address: " email
git config --local user.email "${email}"
printf "${CYAN}User email was set to '${email}'.${NC}"

echo
echo

# Set user name
read -p "Set your user name: " name
git config --local user.name "${name}"
printf "${CYAN}User name was set to '${name}'.${NC}"

echo
echo

GITFLOW_PATH_HOOKS="${CURRENT_DIR}/.git/hooks"
git config --local gitflow.path.hooks "${GITFLOW_PATH_HOOKS}"
printf "${GREEN}GitFlow hooks path was successfully set to '${GITFLOW_PATH_HOOKS}'.${NC}"

echo
echo

# Connect .gitconfig
GITCONFIG_PATH="${CURRENT_DIR}/.gitconfig"
git config --local include.path "${GITCONFIG_PATH}"
printf "${GREEN}.gitconfig path was successfully set to '${GITCONFIG_PATH}'.${NC}"
echo
printf "${GREEN}----${NC}"
echo