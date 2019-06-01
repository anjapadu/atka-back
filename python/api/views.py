from django.shortcuts import render

from rest_framework.decorators import api_view
from rest_framework.response import Response
from rest_framework import viewsets

from . import models
from .serializers import AdopcionSerializer, AnimalSerializer

# Create your views here.

@api_view(['GET'])
def hello_world(request):
    return Response({"foo": "bar"})


class AdopcionesViewSet(viewsets.ModelViewSet):
    queryset = models.Adopciones.objects.all()
    serializer_class = AdopcionSerializer


class AnimalesViewSet(viewsets.ModelViewSet):
    queryset = models.Animales.objects.all()
    serializer_class = AnimalSerializer
