from django.db import models

# Create your models here.
class Accesos(models.Model):
    correo = models.CharField(primary_key=True, max_length=255)
    contrasena = models.CharField(max_length=255, blank=True, null=True)
    tipo_cuenta = models.CharField(max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = "accesos"


class Adopciones(models.Model):
    fecha_adop = models.DateTimeField(blank=True, null=True)
    fecha_pub = models.DateTimeField(blank=True, null=True)
    lugar_latitud = models.FloatField(blank=True, null=True)
    lugar_longitud = models.FloatField(blank=True, null=True)
    animal = models.ForeignKey(
        "Animales", models.DO_NOTHING, db_column="animal", blank=True, null=True
    )
    organizacion_oferta = models.ForeignKey(
        "Personas",
        models.DO_NOTHING,
        db_column="organizacion_oferta",
        blank=True,
        null=True,
        related_name='organizacion_oferta',
    )
    persona_adopcion = models.ForeignKey(
        "Personas",
        models.DO_NOTHING,
        db_column="persona_adopcion",
        blank=True,
        null=True,
        related_name='persona_adopcion',
    )
    persona_oferta = models.ForeignKey(
        "Personas", models.DO_NOTHING, db_column="persona_oferta", blank=True, null=True
    )

    class Meta:
        managed = False
        db_table = "adopciones"


class Animales(models.Model):
    color = models.CharField(max_length=20, blank=True, null=True)
    descripcion = models.CharField(max_length=255, blank=True, null=True)
    estado = models.IntegerField(blank=True, null=True)
    estado_salud = models.CharField(max_length=255, blank=True, null=True)
    fecha_nac = models.DateTimeField(blank=True, null=True)
    imagen = models.CharField(max_length=255, blank=True, null=True)
    nombre = models.CharField(max_length=25, blank=True, null=True)
    raza = models.CharField(max_length=30, blank=True, null=True)
    tamaño = models.FloatField(blank=True, null=True)
    organizacionruc = models.ForeignKey(
        "Organizaciones",
        models.DO_NOTHING,
        db_column="organizacionruc",
        blank=True,
        null=True,
    )
    persona_dni = models.ForeignKey(
        "Personas", models.DO_NOTHING, db_column="persona_dni", blank=True, null=True
    )
    sexo = models.CharField(max_length=1, blank=True, null=True)

    class Meta:
        managed = False
        db_table = "animales"


class Compras(models.Model):
    estado = models.IntegerField(blank=True, null=True)
    fecha_aceptacion = models.DateTimeField(blank=True, null=True)
    fecha_entrega = models.DateTimeField(blank=True, null=True)
    fecha_solicitud = models.DateTimeField(blank=True, null=True)
    organizacion_compra = models.ForeignKey(
        "Organizaciones",
        models.DO_NOTHING,
        db_column="organizacion_compra",
        blank=True,
        null=True,
        related_name="organizacion_compra",
    )
    organizacion_oferta = models.ForeignKey(
        "Organizaciones",
        models.DO_NOTHING,
        db_column="organizacion_oferta",
        blank=True,
        null=True,
        related_name="organizacion_oferta",
    )
    persona_compra = models.ForeignKey(
        "Organizaciones",
        models.DO_NOTHING,
        db_column="persona_compra",
        blank=True,
        null=True,
        related_name="persona_compra",
    )
    total_compra = models.FloatField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = "compras"


class DetallesCompras(models.Model):
    cantidad = models.IntegerField(blank=True, null=True)
    sub_total = models.FloatField(blank=True, null=True)
    compra = models.ForeignKey(
        Compras, models.DO_NOTHING, db_column="compra", blank=True, null=True
    )

    class Meta:
        managed = False
        db_table = "detalles_compras"


class Donaciones(models.Model):
    monto = models.FloatField(blank=True, null=True)
    descripcion = models.CharField(max_length=255, blank=True, null=True)
    fecha_cierre = models.DateTimeField(blank=True, null=True)
    fecha_pub = models.DateTimeField(blank=True, null=True)
    lugar_latitud = models.FloatField(blank=True, null=True)
    lugar_longitud = models.FloatField(blank=True, null=True)
    monto_acumulado = models.FloatField(blank=True, null=True)
    monto_solicitado = models.FloatField(blank=True, null=True)
    donante = models.ForeignKey(
        "Personas", models.DO_NOTHING, db_column="donante", blank=True, null=True
    )
    post = models.ForeignKey(
        "self", models.DO_NOTHING, db_column="post", blank=True, null=True
    )
    organizacion_solicitud = models.ForeignKey(
        "Organizaciones",
        models.DO_NOTHING,
        db_column="organizacion_solicitud",
        blank=True,
        null=True,
    )
    persona_solicitud = models.ForeignKey(
        "Personas",
        models.DO_NOTHING,
        db_column="persona_solicitud",
        blank=True,
        null=True,
        related_name='persona_solicitud'
    )

    class Meta:
        managed = False
        db_table = "donaciones"


class Organizaciones(models.Model):
    ruc = models.CharField(primary_key=True, max_length=11)
    descricion = models.CharField(max_length=255, blank=True, null=True)
    direccion = models.CharField(max_length=255, blank=True, null=True)
    estado = models.IntegerField(blank=True, null=True)
    imagen = models.CharField(max_length=255, blank=True, null=True)
    razon_social = models.CharField(max_length=30, blank=True, null=True)
    telefono = models.CharField(max_length=9, blank=True, null=True)
    correo = models.ForeignKey(
        Accesos, models.DO_NOTHING, db_column="correo", blank=True, null=True
    )

    class Meta:
        managed = False
        db_table = "organizaciones"


class Personas(models.Model):
    dni = models.CharField(primary_key=True, max_length=8)
    apellido = models.CharField(max_length=25, blank=True, null=True)
    estado = models.IntegerField(blank=True, null=True)
    fecha_nac = models.DateTimeField(blank=True, null=True)
    imagen = models.CharField(max_length=255, blank=True, null=True)
    nombre = models.CharField(max_length=25, blank=True, null=True)
    telefono = models.CharField(max_length=9, blank=True, null=True)
    correo = models.ForeignKey(
        Accesos, models.DO_NOTHING, db_column="correo", blank=True, null=True
    )
    direccion = models.CharField(max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = "personas"


class Productos(models.Model):
    descripcion = models.CharField(max_length=255, blank=True, null=True)
    estado = models.IntegerField(blank=True, null=True)
    imagen = models.CharField(max_length=255, blank=True, null=True)
    nombre = models.CharField(max_length=255, blank=True, null=True)
    precio = models.FloatField(blank=True, null=True)
    organizacionruc = models.ForeignKey(
        Organizaciones,
        models.DO_NOTHING,
        db_column="organizacionruc",
        blank=True,
        null=True,
    )
    categoria = models.CharField(max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = "productos"


class SolicitudesAdopciones(models.Model):
    estado = models.IntegerField(blank=True, null=True)
    adopcion = models.ForeignKey(
        Adopciones, models.DO_NOTHING, db_column="adopcion", blank=True, null=True
    )
    persona = models.ForeignKey(
        Personas, models.DO_NOTHING, db_column="persona", blank=True, null=True
    )

    class Meta:
        managed = False
        db_table = "solicitudes_adopciones"
