#!/usr/bin/env bash

#
# Copyright 2021, Yurii Serhiichuk
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
#

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
