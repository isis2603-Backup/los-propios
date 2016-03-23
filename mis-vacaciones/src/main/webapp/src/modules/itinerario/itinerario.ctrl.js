/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {

    // es parte del módulo "itinerarioModule"
    var mod = ng.module("itinerarioModule");

    // crea el controlador con dependencias a $scope y a personService
    mod.controller("itinerarioCtrl", ["$scope", "itinerarioService", function ($scope, svc) {

            $scope.itinerarios = [];
            $scope.fechaInicio = "";
            $scope.fechaFin = "";
            $scope.idItinerario = "";
            $scope.idParada = "";
            $scope.nombreParada = "";
            $scope.ciudadParada = "";
            $scope.actividadParada = "";
            $scope.fechaInicioParada = "";
            $scope.fechaFinParada = "";
            $scope.paradas = [];

            // y que usan funciones definidas en el servicio
            $scope.agregarItinerario = function () {
                var itinerario = [$scope.idItinerario, $scope.fechaInicio, $scope.fechaFin];
                svc.saveRecord(itinerario);
            };

            $scope.listarItinerarios = function () {
                return svc.fetchRecords().then(function (response)
                {
                    $scope.itinerarios = response.data;
                });
            };

            $scope.agregarParada = function () {
                var parada = [$scope.idParada, $scope.nombreParada, $scope.ciudadParada, $scope.actividadParada, $scope.fechaInicioParada, $scope.fechaFinParada];
                svc.saveRecordDos(parada);
            };

            $scope.listarParadas = function () {
                return svc.fetchRecordsDos().then(function (response)
                {
                    $scope.paradas = response.data;
                });
            };
        }]);

})(window.angular);
