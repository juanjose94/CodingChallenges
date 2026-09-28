import { Injectable } from '@angular/core';

export interface IExpense {
  item: string;
  amount: number;
}

@Injectable({ providedIn: 'root' })
export class AppService {
  private expenses: IExpense[] = [];

  constructor() {}

  getExpenses(): IExpense[] {
    return this.expenses;
  }

  addExpense(expense: IExpense): void {
    this.expenses = [...this.expenses, expense];
  }

  deleteExpense(index: number): void {
    this.expenses = this.expenses.filter((_, i) => i !== index);
  }

  getTotal(): number {
    return this.expenses.reduce((total, expense) => total + expense.amount, 0);
  }
}
