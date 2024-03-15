"use strict";
var __esDecorate = (this && this.__esDecorate) || function (ctor, descriptorIn, decorators, contextIn, initializers, extraInitializers) {
    function accept(f) { if (f !== void 0 && typeof f !== "function") throw new TypeError("Function expected"); return f; }
    var kind = contextIn.kind, key = kind === "getter" ? "get" : kind === "setter" ? "set" : "value";
    var target = !descriptorIn && ctor ? contextIn["static"] ? ctor : ctor.prototype : null;
    var descriptor = descriptorIn || (target ? Object.getOwnPropertyDescriptor(target, contextIn.name) : {});
    var _, done = false;
    for (var i = decorators.length - 1; i >= 0; i--) {
        var context = {};
        for (var p in contextIn) context[p] = p === "access" ? {} : contextIn[p];
        for (var p in contextIn.access) context.access[p] = contextIn.access[p];
        context.addInitializer = function (f) { if (done) throw new TypeError("Cannot add initializers after decoration has completed"); extraInitializers.push(accept(f || null)); };
        var result = (0, decorators[i])(kind === "accessor" ? { get: descriptor.get, set: descriptor.set } : descriptor[key], context);
        if (kind === "accessor") {
            if (result === void 0) continue;
            if (result === null || typeof result !== "object") throw new TypeError("Object expected");
            if (_ = accept(result.get)) descriptor.get = _;
            if (_ = accept(result.set)) descriptor.set = _;
            if (_ = accept(result.init)) initializers.unshift(_);
        }
        else if (_ = accept(result)) {
            if (kind === "field") initializers.unshift(_);
            else descriptor[key] = _;
        }
    }
    if (target) Object.defineProperty(target, contextIn.name, descriptor);
    done = true;
};
var __runInitializers = (this && this.__runInitializers) || function (thisArg, initializers, value) {
    var useValue = arguments.length > 2;
    for (var i = 0; i < initializers.length; i++) {
        value = useValue ? initializers[i].call(thisArg, value) : initializers[i].call(thisArg);
    }
    return useValue ? value : void 0;
};
var __setFunctionName = (this && this.__setFunctionName) || function (f, name, prefix) {
    if (typeof name === "symbol") name = name.description ? "[".concat(name.description, "]") : "";
    return Object.defineProperty(f, "name", { configurable: true, value: prefix ? "".concat(prefix, " ", name) : name });
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.BicycleServiceService = void 0;
var core_1 = require("@angular/core");
var rxjs_1 = require("rxjs");
var BicycleServiceService = function () {
    var _classDecorators = [(0, core_1.Injectable)({
            providedIn: 'root'
        })];
    var _classDescriptor;
    var _classExtraInitializers = [];
    var _classThis;
    var BicycleServiceService = _classThis = /** @class */ (function () {
        function BicycleServiceService_1(typeService, brandService) {
            this.typeService = typeService;
            this.brandService = brandService;
            this.bicycles = [
                { bicycleId: 1, name: 'Mountain Bike', value: 500, typeId: 1, brandId: 1 },
                { bicycleId: 2, name: 'Road Bike', value: 400, typeId: 2, brandId: 2 },
            ];
            this.buttonStateSubject = new rxjs_1.BehaviorSubject(true);
        }
        BicycleServiceService_1.prototype.getState = function () {
            return this.buttonStateSubject.value;
        };
        BicycleServiceService_1.prototype.toggleButtonState = function () {
            this.buttonStateSubject.next(!this.buttonStateSubject.value);
        };
        BicycleServiceService_1.prototype.getBicycle = function (id) {
            //@ts-ignore
            var bicycle = this.bicycles.find(function (b) { return b.bicycleId === id; });
            if (!bicycle) {
                throw new Error("Bicycle With the ID ".concat(id, " was not found."));
            }
            return bicycle;
        };
        BicycleServiceService_1.prototype.getAllBicycle = function () {
            return this.bicycles.map(function (b) { return ({
                bicycleId: b.bicycleId,
                name: b.name,
                value: b.value,
                typeId: b.typeId,
                brandId: b.brandId
            }); });
        };
        BicycleServiceService_1.prototype.getFullBicycle = function (id) {
            var bicycle = this.bicycles.find(function (b) { return b.bicycleId == id; });
            //@ts-ignore
            if (bicycle) {
                return {
                    bicycleId: bicycle.bicycleId,
                    name: bicycle.name,
                    value: bicycle.value,
                    type: this.typeService.getTypeName([bicycle.typeId]),
                    brand: this.brandService.getBrandName(bicycle.brandId),
                };
            }
            else {
                return;
            }
        };
        BicycleServiceService_1.prototype.getBicycleByBrandId = function (id) {
            var bicycle = this.bicycles.find(function (bicycle) { return bicycle.brandId === id; }) || null;
            if (!bicycle)
                throw new Error("Brand with ID ".concat(id, " was not found."));
            return bicycle;
        };
        BicycleServiceService_1.prototype.getBicycleOfBrand = function (id) {
            var b = [];
            var brand = this.brandService.getBrand(id);
            var bicycle = this.getBicycleByBrandId(brand.brandId);
            //@ts-ignore
            b.push(bicycle);
            if (bicycle) {
                //@ts-ignore
                var typename_1 = this.typeService.getTypeName([bicycle.typeId]);
                var brand_1 = this.brandService.getBrandName(bicycle.brandId);
                return b.map(function (b) { return ({
                    name: b.name,
                    value: b.value,
                    type: typename_1[0],
                    brand: brand_1
                }); });
            }
        };
        return BicycleServiceService_1;
    }());
    __setFunctionName(_classThis, "BicycleServiceService");
    (function () {
        var _metadata = typeof Symbol === "function" && Symbol.metadata ? Object.create(null) : void 0;
        __esDecorate(null, _classDescriptor = { value: _classThis }, _classDecorators, { kind: "class", name: _classThis.name, metadata: _metadata }, null, _classExtraInitializers);
        BicycleServiceService = _classThis = _classDescriptor.value;
        if (_metadata) Object.defineProperty(_classThis, Symbol.metadata, { enumerable: true, configurable: true, writable: true, value: _metadata });
        __runInitializers(_classThis, _classExtraInitializers);
    })();
    return BicycleServiceService = _classThis;
}();
exports.BicycleServiceService = BicycleServiceService;
