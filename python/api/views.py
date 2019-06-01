from django.shortcuts import render
from django.shortcuts import get_object_or_404

from rest_framework.decorators import api_view
from rest_framework.response import Response
from rest_framework import viewsets

from . import models
from .serializers import AdopcionSerializer, AnimalSerializer

# Create your views here.

@api_view(['GET'])
def hello_world(request):
    return Response({"foo": "bar"})

@api_view(['POST'])
def login(request):
    raw_data = request.data
    user = get_object_or_404(models.Accesos, correo=raw_data.get('correo'))
    if user.contrasena == raw_data.get('contrasena'):
        result = {'result': 'ok'}
    result = {'result': 'ok'}
    return Response(result)


class AdopcionesViewSet(viewsets.ModelViewSet):
    queryset = models.Adopciones.objects.all()
    serializer_class = AdopcionSerializer


class AnimalesViewSet(viewsets.ModelViewSet):
    queryset = models.Animales.objects.all()
    serializer_class = AnimalSerializer
