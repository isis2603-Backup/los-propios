(function (ng) {

    var mod = ng.module("mainApp", ["ui.router"]);

    mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/principal");
            $stateProvider
                    .state('principal', {
                        url: '/principal',
                        templateUrl: "src/modules/principal/principal.tpl.html"
                    })
                    .state('evento', {
                        url: '/evento',
                        templateUrl: "src/modules/evento/evento.tpl.html"
                    })
                    .state('perfilUsuario', {
                        url: '/perfil',
                        templateUrl: "src/modules/perfilUsuario/perfilUsuario.html"
                    })
                    .state('ciudad', {
                        url: '/ciudad',
                        templateUrl: "src/modules/ciudad/ciudad.tpl.html"
                    })
                    .state('itinerario', {
                        url: '/itinerario',
                        templateUrl: "src/modules/itinerario/itinerario.html"
                    })
                    .state('foro', {
                        url: '/foro',
                        templateUrl: "src/modules/foro/foro.tpl.html"
                    })
                    .state('contacto', {
                        url: '/contacto',
                        templateUrl: "src/modules/contactenos/contactenos.tpl.html"
                    })

                    .state('infoCiudad', {
                        url: '/infoCiudad',
                        templateUrl: "src/modules/ciudad/infoCiudad.tpl.html"
                    })
                    .state('servicios', {
                        url: '/servicios',
                        templateUrl: "src/modules/servicios/servicios.tpl.html"
                    })
                    .state('about', {
                        url: '/about',
                        templateUrl: "src/modules/about/about.tpl.html"
                    })
                    ;

        }]);
})(window.angular);