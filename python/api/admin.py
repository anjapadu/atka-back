from django.contrib import admin

from . import models

# Register your models here.
#
#
@admin.register(models.Accesos)
class AccesosAdmin(admin.ModelAdmin):
    pass


@admin.register(models.Adopciones)
class AdopcionesAdmin(admin.ModelAdmin):
    pass


@admin.register(models.Animales)
class AnimalesAdmin(admin.ModelAdmin):
    pass


@admin.register(models.Compras)
class ComprasAdmin(admin.ModelAdmin):
    pass


@admin.register(models.DetallesCompras)
class DetallesComprasAdmin(admin.ModelAdmin):
    pass


@admin.register(models.Donaciones)
class DonacionesAdmin(admin.ModelAdmin):
    pass


@admin.register(models.Organizaciones)
class OrganizacionesAdmin(admin.ModelAdmin):
    pass


@admin.register(models.Personas)
class PersonasAdmin(admin.ModelAdmin):
    pass


@admin.register(models.Productos)
class ProductosAdmin(admin.ModelAdmin):
    pass


@admin.register(models.SolicitudesAdopciones)
class SolicitudesAdopcionesAdmin(admin.ModelAdmin):
    pass
