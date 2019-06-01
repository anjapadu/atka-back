from django.db import models

# Create your models here.
class Accesos(models.Model):
    correo = models.CharField(max_length=255, primary_key=True)
    contrasena = models.CharField(max_length=255)
    tipo_cuenta = models.CharField(max_length=255)

    class Meta:
        managed = False
        db_table = 'accesos'

class Personas(models.Model):
    dni = models.CharField(max_length=8, primary_key=True)
    nombre = models.CharField(max_length=25)
    apellido = models.CharField(max_length=25)
    estado = models.IntegerField()
    fecha_nac = models.DateField()
    imagen = models.CharField(max_length=255)
    telefono = models.CharField(max_length=25)
    correo = models.ForeignKey('Accesos', on_delete=models.CASCADE, db_column='correo')

    class Meta:
        managed = False
        db_table = 'personas'
