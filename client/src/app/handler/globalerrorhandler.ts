import {ErrorHandler, Injectable, Injector} from '@angular/core';
import {HttpErrorResponse} from '@angular/common/http';
import {COMMON_ERROR_MESSAGE} from '../utility/varlist/codeVarlist';
import {ToastService} from '../services/toast/toast.service';

@Injectable()
export class GlobalErrorHandler implements ErrorHandler {

  constructor(
    private injector: Injector,
    public toastService: ToastService
  ) {
  }

  handleError(error: Error | HttpErrorResponse) {
    if (error instanceof HttpErrorResponse) {
      this.toastService.showToast(COMMON_ERROR_MESSAGE, 'error');
    }
  }
}
