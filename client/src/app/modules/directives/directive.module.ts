import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegexFormatDirective } from '../../directives/regex-format.directive';


@NgModule({
  declarations: [RegexFormatDirective],
  imports: [
    CommonModule
  ],
  exports: [RegexFormatDirective]
})
export class DirectiveModule { }
