import { TariffaCorriere } from "./tariffa-corriere";

export interface Ordine {
  id: number,
  numero: number,
  data: string,
  preventivo_migliore: TariffaCorriere
}
