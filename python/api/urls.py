from django.urls import path, include
from rest_framework.routers import DefaultRouter

from . import views

router = DefaultRouter()
router.register(r'adopciones', views.AdopcionesViewSet)
router.register(r'animales', views.AnimalesViewSet)


urlpatterns = [
    path('foo/', views.hello_world),
    path('login/', views.login),
    path('', include(router.urls)),
    ]
