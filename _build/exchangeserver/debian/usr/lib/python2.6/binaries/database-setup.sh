#!/bin/bash

mysql -u root -psignature < /usr/lib/python2.6/binaries/db-setup.sql
mysql -u root -psignature < /usr/lib/python2.6/binaries/Admin.sql
mysql -u root -psignature < /usr/lib/python2.6/binaries/City.sql
mysql -u root -psignature < /usr/lib/python2.6/binaries/Country.sql


