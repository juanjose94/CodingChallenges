import { Component } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'expense-form',
  templateUrl: './expenseForm.components.html',
})
export class ExpenseForm {
  item = '';
  amount = '';

  constructor(public appService: AppService) {}

  get isInvalid(): boolean {
    return this.item.trim() === '' || this.amount === '';
  }

  addExpense(): void {
    if (this.isInvalid) {
      return;
    }
    this.appService.addExpense({ item: this.item.trim(), amount: Number(this.amount) });
    this.item = '';
    this.amount = '';
  }
}
