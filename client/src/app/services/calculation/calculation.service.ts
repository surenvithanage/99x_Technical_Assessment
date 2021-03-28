import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {getEndpoint, SECURE} from '../../utility/constant';
import {PriceEngine} from '../../bean/price/price-engine';
import {Observable} from 'rxjs';
import {Calculate} from '../../bean/calculate/calculate';

@Injectable({
  providedIn: 'root'
})
export class CalculationService {

  public optimizePriceUrl: string;
  public calculateProductCostUrl: string;

  constructor(
    private http: HttpClient
  ) {
    this.optimizePriceUrl = `${getEndpoint(SECURE)}/optimize`;
    this.calculateProductCostUrl = `${getEndpoint(SECURE)}/calculate`;
  }

  priceEngineCalculate(price: PriceEngine): Observable<any> {
    return this.http.post(`${this.optimizePriceUrl}`, price);
  }

  calculatePrice(calculate: Calculate): Observable<any> {
    return this.http.post(`${this.calculateProductCostUrl}`, calculate);
  }
}
