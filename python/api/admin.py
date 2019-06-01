from django.contrib import admin

from . import models

# Register your models here.
#

@admin.register(models.Personas)
class PersonasAdmin(admin.ModelAdmin):
    pass

@admin.register(models.Accesos)
class AccesosAdmin(admin.ModelAdmin):
    pass
