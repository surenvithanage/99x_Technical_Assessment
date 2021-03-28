import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {getEndpoint, SECURE} from '../../utility/constant';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  public productListUrl: string;

  constructor(
    private http: HttpClient
  ) {
    this.productListUrl = `${getEndpoint(SECURE)}/product`;
  }

  productList(): Observable<any> {
    return this.http.get(`${this.productListUrl}`);
  }

}
