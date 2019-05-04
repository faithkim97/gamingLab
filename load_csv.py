import requests
import csv
from base64 import b64encode
import os

password = "adminPass"

if 'ADMIN_PASSWORD' in os.environ:
  password = os.environ['ADMIN_PASSWORD'];

path = "gaminglabinventoryTRUE.csv"
with open(path) as fp:
  csvReader = csv.reader(fp)
  header = next(csvReader)
  for row in csvReader:
    data = dict(zip(header, row))
    print(data)
    requests.post('http://localhost:8080/admin/addGameCSV',
                  data=data,
                  headers={'Authorization': 'Basic '+
                                            b64encode( ('admin:'+password).encode('UTF-8') ).decode('UTF-8')})


