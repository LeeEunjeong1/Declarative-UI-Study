//
//  HeaderView.swift
//  iOS
//
//  Created by Financial CB on 2023/07/11.
//

import SwiftUI

struct HeaderView: View {
    var body: some View {
        HStack {
            Image(systemName: "bell")
                .frame(maxWidth: .infinity, alignment: .leading)
            Text("MUSINSA")
                .frame(maxWidth: .infinity, alignment: .center)
            HStack {
                Image(systemName: "magnifyingglass")
                    .padding(5)
                Image(systemName: "bag")
            }
            .frame(maxWidth: .infinity, alignment: .trailing)
        }
    }
}

struct HeaderView_Previews: PreviewProvider {
    static var previews: some View {
        HeaderView()
    }
}
