# Prueba MELI

## Tecnologias y Arquitecturas implementadas

- Jetpack Compose
- Clean Architecture
- Coroutines
- MutableState
- MVVM
- Retrofit
- Coil
- Dagger Hilt
- Lottie
- Project Modularization
- Gradle KTS

## Trello ( para ver como se abarco las tareas del proyecto )
[Trello](https://trello.com/invite/b/XKqImFyD/ATTIb97a4db2eff9f2a8d23d6bbca5ce3c9b699CED05/meli-prueba)

## Video Demostrativo

https://github.com/HeinerGomez/MELI-APP/assets/27563731/b8028166-3db5-4cb5-9528-123315df735c

## Notas

- UX en el buscador para limpiar busquedas y que lance automaticamente el teclado para una nueva busqueda
- la aplicación conserva su estado si el telefono es cambiado de orientación
- procesos en segundo plano se manejaron con coroutines
- se realizarón ✔️ 13 test que se encuentran en el package app, en los cuales se cubrienron los casos de uso y los viemodel
- el proyecto quedó modularizado creando los siguientes módulos: app, shared, presentation, buildSrc(para configuración del proyecto), data, domain
- se crearon componentes reutilizables en jetpack compose
