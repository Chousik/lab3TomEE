build:
	docker-compose build --no-cache

# Поднимаем контейнеры
up:
	docker-compose up

# Полный процесс (удалить контейнеры, образы, собрать и поднять)
all: build up