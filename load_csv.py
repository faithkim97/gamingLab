import requests
import csv

path = "Gaming Lab Inventory - Games.csv"
with open(path) as fp:
  csvReader = csv.reader(fp)
  header = next(csvReader)
  for row in csvReader:
    data = dict(zip(header, row))
    del data['checked_out']
    print(data)
    requests.post('http://localhost:8080/game/addGame', data=data)


