@echo off
chcp 65001
wmic process where(name="nginx.exe") delete
echo start...
nginx.exe