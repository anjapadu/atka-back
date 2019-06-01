from django.urls import path

from . import views


urlpatterns = [
    path('foo/', views.hello_world)
    ]
