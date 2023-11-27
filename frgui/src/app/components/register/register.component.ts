import { Component } from '@angular/core';

import { CommonModule } from '@angular/common';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBar } from '@angular/material/snack-bar';
import {
  FormGroup,
  Validators,
  FormBuilder,
  ReactiveFormsModule,
} from '@angular/forms';
import { UserRegistrationService } from 'src/app/services/user/user-registration/user-registration.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatIconModule,
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent {
  hide: boolean = true;
  userRegistrationForm!: FormGroup;
  constructor(
    private snackBar: MatSnackBar,
    private formBuilder: FormBuilder,
    private userRegistrationService: UserRegistrationService
  ) {}
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.userRegistrationForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', Validators.required],
    });
  }

  onSubmit(): void {
    this.userRegistrationService
      .registerUser(this.userRegistrationForm.value)
      .subscribe((response) => {
        this.snackBar.open('Registration Successful!', 'Close', {
          duration: 3000,
        });
        error: this.snackBar.open(
          'Registration failed, submit again.',
          'Close',
          { duration: 3000 }
        );
      });

    this.userRegistrationForm.reset();
    this.userRegistrationForm.markAsPristine();
    this.userRegistrationForm.markAsUntouched();
  }
}
