import {Injectable} from '@angular/core';
import {ToastrService} from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class ToastService {
  constructor(private toastr: ToastrService) {
  }

  showToast(message: string, type: string) {
    this.toastr.clear();
    switch (type) {
      case 'error': {
        this.toastr.error(message, 'Error');
        break;
      }
      case 'warning': {
        this.toastr.info(message, 'Warning');
        break;
      }
      case 'success': {
        this.toastr.success(message, 'Success');
        break;
      }
    }
  }
}
