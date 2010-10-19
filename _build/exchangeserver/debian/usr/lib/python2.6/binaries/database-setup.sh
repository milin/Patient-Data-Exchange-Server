#!/bin/bash

mysql -u root -psignature < db-setup.sql
mysql -u root -psignature projecthl7 < Admin.sql
mysql -u root -psignature projecthl7 < City.sql
mysql -u root -psignature projecthl7 < Country.sql
mysql -u root -psignature projecthl7 < SystemControl.sql

