import { CelciusToFahrenheitPipe } from './celcius-to-fahrenheit.pipe';

describe('CelciusToFahrenheitPipe', () => {
  it('create an instance', () => {
    const pipe = new CelciusToFahrenheitPipe();
    expect(pipe).toBeTruthy();
  });
});
