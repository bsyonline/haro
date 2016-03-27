#!/usr/bin/python
# -*-coding:UTF-8-*-

import time
from fabric.api import env, run, sudo, roles
from fabric.context_managers import cd
from fabric.operations import put
from fabric.contrib.project import rsync_project
import fab_lib

