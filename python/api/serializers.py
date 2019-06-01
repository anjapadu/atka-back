from rest_framework import serializers

from . import models

class AdopcionSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Adopciones
        fields = '__all__'


class AnimalSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Animales
        fields = '__all__'
