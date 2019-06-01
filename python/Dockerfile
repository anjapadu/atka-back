FROM python:3
ENV PYTHONUNBUFFERED 1
RUN mkdir /code
WORKDIR /code
COPY Pipfile /code/
RUN pip install pipenv
RUN pipenv install --system --deploy
RUN pip install -r requirements.txt

COPY ./hackatrix_back/. /code/
