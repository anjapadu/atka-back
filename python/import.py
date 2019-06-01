#!/usr/bin/env python
#
from api import models
import datetime
import random

filename = '/Users/soloidx/Downloads/Animal.csv'

csv_file = open(filename)

cont = 0
for line in csv_file:
    if cont == 0:
        cont+= 1
        continue
    line = line.split(',')

    acceso = models.Animales.objects.get(correo=line[5].strip())

    obj = models.Organizaciones(
        nombre=line[1].strip(),
        fecha_nac=datetime.datetime.strptime('%m/%d/%y', line[2].strip()),
        tamaño=line[3].strip(),
        sexo=line[4].strip()[:8],
        correo=acceso,
        imagen='https://heroeslounge.gg/storage/app/uploads/public/5bc/5d1/bd0/5bc5d1bd0e52c656483778.jpg',
        estado=0,
        estado_salud="Sano",
        raza=['Bulldog', 'Pekines', 'Pastor aleman'][random.randrange(0,3)],
    )

    obj.save()
    print(line)
