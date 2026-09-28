import { Component } from '@angular/core';
import { AppService, IExpense } from './app.service';

@Component({
  selector: 'expense-list',
  templateUrl: './expenseList.components.html',
})
export class ExpenseList {
  constructor(public appService: AppService) {}

  get expenses(): IExpense[] {
    return this.appService.getExpenses();
  }

  get total(): number {
    return this.appService.getTotal();
  }

  deleteExpense(index: number): void {
    this.appService.deleteExpense(index);
  }

  trackByValue(_index: number, item: unknown): unknown {
    return item;
  }
}
