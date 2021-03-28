import {Component, OnInit, ViewChild} from '@angular/core';
import {ResponseBean} from './bean/response/response-bean';
import {ProductService} from './services/product/product.service';
import {ToastService} from './services/toast/toast.service';
import {CALCULATION_DATA, PRICE_ENGINE_DATA, PRODUCT_LIST_DATA} from './utility/varlist/codeVarlist';
import {Calculate} from './bean/calculate/calculate';
import {PriceEngine} from './bean/price/price-engine';
import {NgForm} from '@angular/forms';
import {CalculationService} from './services/calculation/calculation.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  // obtaining the reference of the form
  @ViewChild('f')
  f: NgForm;

  title = 'Price Engine Calculator';

  public productList: any = [];

  public responseBean: ResponseBean;

  public viewCarton: boolean;
  public viewUnit: boolean;

  public calculateModel = new Calculate('', '', '', false, false);
  public priceEngineModel = new PriceEngine('', '', '');

  public optimizeNoOfUnits;
  public optimizeNoOCartons;
  public totalPrice;

  constructor(
    public productService: ProductService,
    public toastService: ToastService,
    public calculationService: CalculationService
  ) {
    this.viewCarton = false;
    this.viewUnit = false;
    this.optimizeNoOfUnits = '';
    this.optimizeNoOCartons = '';
    this.totalPrice = '';
  }

  ngOnInit() {
    this._prepare();
  }

  _prepare() {
    this.productList = [];
    this.retrieveProductList();
  }

  retrieveProductList() {
    this.productService.productList().subscribe(
      data => {
        this.responseBean = data;
        if (this.responseBean.requestOk === true) {
          const filteredresult = this.responseBean.data.filter(i => i.key === PRODUCT_LIST_DATA);
          if (JSON.stringify(filteredresult) !== '[]') {
            this.productList = filteredresult[0]['value']['data'];
          }
        }
      }, error => {
        this.toastService.showToast(JSON.parse(error.error).message, 'error');
      }
    );
  }

  selectedProduct(event) {
    this.reset();
  }

  selectedQtyType(event) {
    this.reset();
    if (event.target.value === 'unit') {
      this.viewCarton = false;
      this.viewUnit = true;
      this.calculateModel.selectedUnit = true;
      this.calculateModel.selectedCarton = false;
      this.resetQty();
    } else if (event.target.value === 'carton') {
      this.viewUnit = false;
      this.viewCarton = true;
      this.calculateModel.selectedUnit = false;
      this.calculateModel.selectedCarton = true;
      this.resetQty();
    }
  }

  resetQty() {
    this.calculateModel.noOfCartons = '';
    this.calculateModel.noOfUnits = '';
  }

  onSubmit() {
    this.reset();
    this.priceEngineModel.productId = this.calculateModel.productId;
    this.priceEngineModel.noOfUnits = this.calculateModel.noOfUnits;
    this.priceEngineModel.noOfCartons = this.calculateModel.noOfCartons;
    this.calculatePriceEngine(this.priceEngineModel);
    this.calculatePrice(this.calculateModel);
  }

  calculatePriceEngine(priceEngineModel: any) {
    this.calculationService.priceEngineCalculate(priceEngineModel).subscribe(
      data => {
        this.responseBean = data;
        if (this.responseBean.requestOk === true) {
          const filteredresult = this.responseBean.data.filter(i => i.key === PRICE_ENGINE_DATA);
          if (JSON.stringify(filteredresult) !== '[]') {
            this.optimizeNoOfUnits = filteredresult[0]['value']['noOfUnits'];
            this.optimizeNoOCartons = filteredresult[0]['value']['noOfCartons'];
          }
        }
      }, error => {
        this.toastService.showToast(JSON.parse(error.error).message, 'error');
      }
    );
  }

  calculatePrice(calculateModel: any) {
    this.calculationService.calculatePrice(calculateModel).subscribe(
      data => {
        this.responseBean = data;
        if (this.responseBean.requestOk === true) {
          const filteredresult = this.responseBean.data.filter(i => i.key === CALCULATION_DATA);
          if (JSON.stringify(filteredresult) !== '[]') {
            this.totalPrice = filteredresult[0]['value']['price'];
          }
        }
      }, error => {
        this.toastService.showToast(JSON.parse(error.error).message, 'error');
      }
    );
  }

  reset() {
    this.optimizeNoOfUnits = '';
    this.optimizeNoOCartons = '';
    this.totalPrice = '';
  }
}
