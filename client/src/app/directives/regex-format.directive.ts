import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appRegexFormat]'
})
export class RegexFormatDirective {

  // tslint:disable-next-line:no-input-rename
  @Input('regexType') numericType: string; // number , decimal etc

  private regex = {
    number: new RegExp(/^\d+$/),
    decimal: new RegExp(/^[0-9]+(\.[0-9]*){0,1}$/g),
    letter_num: new RegExp(/^[a-zA-Z0-9]+$/g),
    letter_space: new RegExp(/^[a-zA-Z ]+$/g),
    letter_only: new RegExp(/^[a-zA-Z]+$/g),
    number_only: new RegExp(/^[0-9]+$/g)
  };
  private specialKeys = {
    number: [ 'Backspace', 'Tab', 'End', 'Home', 'ArrowLeft', 'ArrowRight' ], //
    decimal: [ 'Backspace', 'Tab', 'End', 'Home', 'ArrowLeft', 'ArrowRight' ], //
    letter_num: [ 'Backspace', 'Tab', 'End', 'Home', 'ArrowLeft', 'ArrowRight' ], //
    letter_space: [ 'Backspace', 'Tab', 'End', 'Home', 'ArrowLeft', 'ArrowRight' ], //
    letter_only: [ 'Backspace', 'Tab', 'End', 'Home', 'ArrowLeft', 'ArrowRight' ], //
    nic: [ 'Backspace', 'Tab', 'End', 'Home', 'ArrowLeft', 'ArrowRight' ]
  };

  constructor(private el: ElementRef) {
  }

  @HostListener('keydown', [ '$event' ])
  onKeyDown(event: KeyboardEvent) {

    const element = this.el.nativeElement;

    if (this.numericType !== 'bank_list') {
      if ((event.key === 'v' || event.key === 'V' || event.ctrlKey)) {
        setTimeout(function (evet) {
          element.click();
        }, 100);
      }
    }

    if (this.specialKeys[this.numericType].indexOf(event.key) !== -1) {
      return;
    }
	
    const current: string = this.el.nativeElement.value;
    const next: string = current.concat(event.key);
    if (next && !String(next).match(this.regex[this.numericType])) {
      event.preventDefault();
    }

  }

  @HostListener('click', [ '$event' ])
  onKeyDown2(event: KeyboardEvent) {

    const current: string = this.el.nativeElement.value;
    const element = this.el.nativeElement;

    if (current) {
      if (!String(current).match(this.regex[this.numericType])) {
        this.el.nativeElement.value = '';
        setTimeout(function (evet) {
          element.click();
        }, 100);
      }
    }

  }
}
